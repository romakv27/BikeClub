package org.dev.bikeclub.service;

import org.dev.bikeclub.dto.ClubDto;
import org.dev.bikeclub.model.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);
    ClubDto findClubById(long clubId);
    void updateClub(ClubDto club);
    void deleteClub(Long clubId);
    List<ClubDto> searchClubs(String query);
}
