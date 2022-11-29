package rsoi.lab2.gateway.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import rsoi.lab2.gateway.requests.PurchaseTicketRequest;
import rsoi.lab2.gateway.responses.*;

import java.util.*;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1")
public class FlightGateway {

    @Value("${services.urls.flight-service-url}")
    private String flightServiceUrl;
    @Value("${services.urls.privilege-service-url}")
    private String privilegeServiceUrl;
    @Value("${services.urls.tickets-service-url}")
    private String ticketsServiceUrl;

    @Value("${services.urls.flight-service-health-url}")
    private  String FlightHealth;

    @Value("${services.urls.privilege-service-health-url}")
    private  String privilegeHealth;

    @Value("${services.urls.tickets-service-health-url}")
    private  String TicketHealth;


    @GetMapping("/flights")
    public ResponseEntity<Object> findAllFlights(@RequestParam int page, @RequestParam int size) {
        String url = UriComponentsBuilder.fromHttpUrl(flightServiceUrl).queryParam("page", page).queryParam("size", size).toUriString();

        return getResponseEntity(url);
    }

    @GetMapping("/privilege")
    public ResponseEntity<Privilege> findPrivilege(@RequestHeader("X-User-Name") String username) {
        Privilege privilege = getPrivilege(username);
        return ResponseEntity.ok(privilege);
    }

    private Privilege getPrivilege(String username) {
        String url = UriComponentsBuilder.fromHttpUrl(privilegeServiceUrl).toUriString();

        return getPrivilegeResponseEntity(url, username).getBody();
    }

    @PostMapping("/tickets")
    public ResponseEntity<Object> purchaseTicket(@RequestHeader("X-User-Name") String username, @RequestBody PurchaseTicketRequest request) {
        if (isFlightExists(request)) {
            FlightResponse flightResponse = getFlightResponse(request.getFlightNumber());
            PurchaseTicketResponse purchaseTicketResponse = getPurchaseTicketResponse(request, username);
            PrivilegeResponse privilegeResponse = getPrivilegeResponse(request, username);
            addToPrivilegeHistory(purchaseTicketResponse.getTicketUid().toString(), privilegeResponse.getId(), privilegeResponse.getBalance() - request.getPrice());
            return ResponseEntity.ok(getBuyTicketResponse(flightResponse, purchaseTicketResponse, privilegeResponse));
        }
        return ResponseEntity.badRequest().body("Flight Number Doesn't Exists");
    }

    @GetMapping("/tickets/{ticketUid}")
    public ResponseEntity<FindTicketByUidResponse> findTicketByUid(@PathVariable("ticketUid") String ticketUid) {
        FindTicketResponse ticketByUidResponse = findTicketByUidResponse(ticketUid);
        FlightResponse flightResponse = getFlightResponse(ticketByUidResponse.getFlightNumber());

        return mapToFindTicketByUidResponseEntity(ticketByUidResponse, flightResponse);
    }

    @GetMapping("tickets")
    public ResponseEntity<List<FindAllUserTicketsResponse>> findAllUserTickets(@RequestHeader("X-User-Name") String username) {
        return ResponseEntity.ok(findAllUserTicketsByUsername(username));
    }

    @DeleteMapping("/tickets/{ticketUid}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTicketByUid(@PathVariable("ticketUid") String ticketUid) {
        deleteTicketByUidResponse(ticketUid);
    }

    private List<FindAllUserTicketsResponse> findAllUserTicketsByUsername(String username) {
        FindTicketsResponse ticketsResponse = getFindAllUserTicketsResponse(username);
        FlightsResponse flightsResponse = getAllFlightsResponse();

        List<FindAllUserTicketsResponse> findAllUserTicketsResponses = new ArrayList<>();
        List<FindTicketResponse> findTicketResponseList = ticketsResponse.getFindTicketResponseList();
        findTicketResponseList.forEach(ticketResponse -> {
            FindAllUserTicketsResponse findAllUserTicketsResponse = new FindAllUserTicketsResponse();
            FlightResponse flightResponse = flightsResponse.getFlightResponseList().stream().filter(flight -> flight.getFlightNumber().equals(ticketResponse.getFlightNumber())).findFirst().orElse(null);
            findAllUserTicketsResponse.setTicketUid(ticketResponse.getTicketUid());
            findAllUserTicketsResponse.setStatus(ticketResponse.getStatus());
            findAllUserTicketsResponse.setPrice(ticketResponse.getPrice());
            findAllUserTicketsResponse.setFlightNumber(ticketResponse.getFlightNumber());
            findAllUserTicketsResponse.setFromAirport(flightResponse.getFromAirport());
            findAllUserTicketsResponse.setToAirport(flightResponse.getToAirport());
            findAllUserTicketsResponse.setDate(flightResponse.getDate());
            findAllUserTicketsResponses.add(findAllUserTicketsResponse);
        });
        return findAllUserTicketsResponses;
    }

    @GetMapping("me")
    public ResponseEntity<UserInformationResponse> findUserInfo(@RequestHeader("X-User-Name") String username) {
        String url = UriComponentsBuilder.fromHttpUrl(privilegeServiceUrl).toUriString();

        Privilege privilege = getPrivilegeResponseEntity(url, username).getBody();
        UserInformationResponse response = new UserInformationResponse();
        response.setTickets(findAllUserTicketsByUsername(username));
        response.setPrivilege(privilege);

        return ResponseEntity.ok(response);
    }

    private ResponseEntity<FindTicketByUidResponse> mapToFindTicketByUidResponseEntity(FindTicketResponse ticketByUidResponse,
                                                                                       FlightResponse flightResponse) {
        FindTicketByUidResponse findTicketByUidResponse = new FindTicketByUidResponse();
        findTicketByUidResponse.setTicketUid(ticketByUidResponse.getTicketUid());
        findTicketByUidResponse.setFlightNumber(ticketByUidResponse.getFlightNumber());
        findTicketByUidResponse.setPrice(ticketByUidResponse.getPrice());
        findTicketByUidResponse.setStatus(ticketByUidResponse.getStatus());
        findTicketByUidResponse.setFromAirport(flightResponse.getFromAirport());
        findTicketByUidResponse.setToAirport(flightResponse.getToAirport());
        findTicketByUidResponse.setDate(flightResponse.getDate());
        return ResponseEntity.ok(findTicketByUidResponse);
    }

    private void deleteTicketByUidResponse(String ticketUid) {
        String url = UriComponentsBuilder.fromHttpUrl(ticketsServiceUrl + "/" + ticketUid).toUriString();
        deleteTicketResponseEntity(url);
    }

    private FindTicketResponse findTicketByUidResponse(String ticketUid) {
        String url = UriComponentsBuilder.fromHttpUrl(ticketsServiceUrl + "/" + ticketUid).toUriString();

        return getFindTicketResponseEntity(url).getBody();
    }

    private FindTicketsResponse getFindAllUserTicketsResponse(String username) {
        String url = UriComponentsBuilder.fromHttpUrl(ticketsServiceUrl).toUriString();

        return getFindAllUserTicketsResponseEntity(url, username).getBody();
    }

    private BuyTicketResponse getBuyTicketResponse(FlightResponse flightResponse, PurchaseTicketResponse purchaseTicketResponse, PrivilegeResponse privilegeResponse) {
        BuyTicketResponse buyTicketResponse = new BuyTicketResponse();
        buyTicketResponse.setFlightNumber(flightResponse.getFlightNumber());
        buyTicketResponse.setPrice(flightResponse.getPrice());
        buyTicketResponse.setFromAirport(flightResponse.getFromAirport());
        buyTicketResponse.setToAirport(flightResponse.getToAirport());
        buyTicketResponse.setDate(flightResponse.getDate());
        buyTicketResponse.setTicketUid(purchaseTicketResponse.getTicketUid().toString());
        buyTicketResponse.setStatus(purchaseTicketResponse.getStatus());
        buyTicketResponse.setPaidByMoney(purchaseTicketResponse.getPrice());
        buyTicketResponse.setPaidByBonuses(0);
        Privilege privilege = new Privilege();
        privilege.setBalance(privilegeResponse.getBalance());
        privilege.setStatus(privilegeResponse.getStatus());
        buyTicketResponse.setPrivilege(privilege);

        return buyTicketResponse;
    }

    private PurchaseTicketResponse getPurchaseTicketResponse(PurchaseTicketRequest request, String username) {
        String ticketUrl = UriComponentsBuilder.fromHttpUrl(ticketsServiceUrl).toUriString();

        Map<String, String> map = new HashMap<>();
        map.put("flightNumber", request.getFlightNumber());
        map.put("price", request.getPrice() + "");
        map.put("username", username);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(map, headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.postForEntity(ticketUrl, entity, PurchaseTicketResponse.class).getBody();
    }

    private void addToPrivilegeHistory(String ticketUid, Long privilegeId, int balanceDiff) {
        String ticketUrl = UriComponentsBuilder.fromHttpUrl(privilegeServiceUrl + "/addToHistory").toUriString();

        Map<String, String> map = new HashMap<>();
        map.put("privilegeId", privilegeId + "");
        map.put("ticket_uid", ticketUid);
        map.put("balanceDiff", balanceDiff + "");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(map, headers);
        RestOperations restOperations = new RestTemplate();

        restOperations.postForEntity(ticketUrl, entity, Object.class);
    }

    private PrivilegeResponse getPrivilegeResponse(PurchaseTicketRequest request, String username) {
        String privilegeUrl = UriComponentsBuilder.fromHttpUrl(privilegeServiceUrl).toUriString();

        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("creditedTicketAmount", request.getPrice() + "");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(map, headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.postForEntity(privilegeUrl, entity, PrivilegeResponse.class).getBody();
    }

    private FlightResponse getFlightResponse(String flightNumber) {
        String flightUrl = UriComponentsBuilder.fromHttpUrl(flightServiceUrl + "/findByFlightNumber")
                .queryParam("flightNumber", flightNumber).toUriString();

        return getFlightResponseEntity(flightUrl).getBody();
    }

    private FlightsResponse getAllFlightsResponse() {
        String flightUrl = UriComponentsBuilder.fromHttpUrl(flightServiceUrl + "/all").toUriString();

        return getFlightsResponseEntity(flightUrl).getBody();
    }

    private Boolean isFlightExists(PurchaseTicketRequest request) {
        String url = UriComponentsBuilder.fromHttpUrl(flightServiceUrl + "/isExists")
                .queryParam("flightNumber", request.getFlightNumber()).toUriString();

        return Boolean.parseBoolean(Objects.requireNonNull(getResponseEntity(url).getBody()).toString());
    }


    private ResponseEntity<Object> getResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, Object.class);
    }

    private ResponseEntity<Privilege> getPrivilegeResponseEntity(String url, String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        headers.set("X-User-Name", username);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, Privilege.class);
    }

    private ResponseEntity<FindTicketResponse> getFindTicketResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, FindTicketResponse.class);
    }

    private void deleteTicketResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();
        restOperations.exchange(url, HttpMethod.DELETE, entity, Object.class);
    }

    private ResponseEntity<FindTicketsResponse> getFindAllUserTicketsResponseEntity(String url, String username) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        headers.set("X-User-Name", username);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, FindTicketsResponse.class);
    }

    private ResponseEntity<FlightResponse> getFlightResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, FlightResponse.class);
    }

    private ResponseEntity<FlightsResponse> getFlightsResponseEntity(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(ACCEPT, APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestOperations restOperations = new RestTemplate();

        return restOperations.exchange(url, HttpMethod.GET, entity, FlightsResponse.class);
    }
}
