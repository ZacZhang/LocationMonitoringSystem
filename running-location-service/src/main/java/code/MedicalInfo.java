package code;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class MedicalInfo {

    private Long fmi;

    // blood flow rate
    private Long bfr;

    @SuppressWarnings("unused")
    private MedicalInfo() {
    }

    public MedicalInfo(long bfr, long fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }

}