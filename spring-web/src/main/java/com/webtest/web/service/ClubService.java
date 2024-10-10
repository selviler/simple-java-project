package com.webtest.web.service;

import com.webtest.web.dto.ClubDto;
import com.webtest.web.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club store(ClubDto clubDto);

    ClubDto findClubById(long id);

    void update(ClubDto club);

    List<ClubDto> searchClubs(String query);
    void delete(Long id);
}
