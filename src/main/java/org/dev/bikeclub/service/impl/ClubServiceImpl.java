package org.dev.bikeclub.service.impl;

import org.dev.bikeclub.dto.ClubDto;
import org.dev.bikeclub.model.Club;
import org.dev.bikeclub.model.User;
import org.dev.bikeclub.repository.ClubRepository;
import org.dev.bikeclub.repository.UserRepository;
import org.dev.bikeclub.security.SecurityUtil;
import org.dev.bikeclub.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.dev.bikeclub.mapper.ClubMapper.mapToClub;
import static org.dev.bikeclub.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {


    private ClubRepository clubRepository;
    private UserRepository userRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository, UserRepository userRepository) {
        this.clubRepository = clubRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        User user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setUser(user);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return mapToClubDto(club);

    }

    @Override
    public void updateClub(ClubDto clubDto) {
        String username = SecurityUtil.getSessionUser();
        User user = userRepository.findByUsername(username);
        Club club = mapToClub(clubDto);
        club.setUser(user);
        clubRepository.save(club);
    }

    @Override
    public void deleteClub(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }
}
