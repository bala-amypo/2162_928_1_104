@RestController
@RequestMapping("/api/issued-devices")
public class IssuedDeviceRecordController {

    private final IssuedDeviceRecordService service;

    public IssuedDeviceRecordController(IssuedDeviceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public IssuedDeviceRecord issue(@RequestBody IssuedDeviceRecord record) {
        return service.issueDevice(record);
    }

    @GetMapping("/employee/{employeeId}")
    public List<IssuedDeviceRecord> getByEmployee(@PathVariable Long employeeId) {
        return service.getIssuedDevicesByEmployee(employeeId);
    }
}
