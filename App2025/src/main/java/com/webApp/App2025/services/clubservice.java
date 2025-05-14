package com.webApp.App2025.services;

import com.webApp.App2025.dto.clubdto;
import com.webApp.App2025.models.club;

import java.util.List;

public interface clubservice {
    List<clubdto> findALlclubs();
    club save(club club);

    clubdto findbyid(long clubid);

    void update(clubdto cld);

    void deletbyid(long clubid);
}
