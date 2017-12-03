package com.kodilla.good.patterns.flights;

import java.util.List;

public interface FlightFindingService {

    List<List<Flight>> find(Repository repository, SearchCriteria searchCriteria);

}
