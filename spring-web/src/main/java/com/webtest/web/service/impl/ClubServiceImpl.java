package com.webtest.web.service.impl;

import com.webtest.web.dto.ClubDto;
import com.webtest.web.models.Club;
import com.webtest.web.repository.ClubRepository;
import com.webtest.web.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.webtest.web.mapper.ClubMapper.mapToClub;
import static com.webtest.web.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }
    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club store(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long id) {
        Club club = clubRepository.findById(id).get();
        return mapToClubDto(club);
    }

    @Override
    public void update(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }


}
