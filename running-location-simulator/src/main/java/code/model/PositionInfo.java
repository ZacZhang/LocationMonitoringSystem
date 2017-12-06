package code.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class PositionInfo {

    private String runningId;
    private Point position;
    private RunnerStatus runnerStatus = RunnerStatus.NONE;

    private Leg leg;

    /**
     * Meters from start of leg
     */
    private Double distanceFromStart;

    /**
     * The speed in m/s
     */
    private Double speed;

}