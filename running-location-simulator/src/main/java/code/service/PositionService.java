package code.service;

import code.model.CurrentPosition;


public interface PositionService {

    void processPositionInfo(long id,
                             CurrentPosition currentPosition,
                             boolean exportPositionsToKml,
                             boolean sendPositionsToDistributionService);

}