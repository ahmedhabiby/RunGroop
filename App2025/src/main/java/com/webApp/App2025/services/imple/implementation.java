package com.webApp.App2025.services.imple;

import com.webApp.App2025.dto.clubdto;
import com.webApp.App2025.jpaReporositry.jparepo;
import com.webApp.App2025.models.club;
import com.webApp.App2025.services.clubservice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository
public class implementation implements clubservice {
    private jparepo jr;

    public implementation(jparepo jr) {
        this.jr = jr;
    }

    @Override
    public List<clubdto> findALlclubs() {
        List<club> l1 =jr.findAll();
        return l1.stream().map(club -> maptoclubdto(club)).collect(Collectors.toList());
    }

    @Override
    public club save(club club) {
        return jr.save(club);
    }

    @Override
    public clubdto findbyid(long clubid) {
        club cb=jr.findById(clubid).get();
        return maptoclubdto(cb);
    }

    @Override
    public void update(clubdto cld) {
        club cl=maptoclubdto(cld);
        jr.save(cl);
    }

    @Override
    public void deletbyid(long clubid) {
        jr.deleteById(clubid);
    }

    private club maptoclubdto(clubdto cld) {
        club cv= club.builder()
                .id(cld.getId())
                .title(cld.getTitle())
                .content(cld.getContent())
                .createdon(cld.getCreatedon())
                .photoUrl(cld.getPhotoUrl())
                .updatedon(cld.getUpdatedon())
                .build();
        return cv;
    }

    private clubdto maptoclubdto(club club) {
        clubdto clubdto1=clubdto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .content(club.getContent())
                .createdon(club.getCreatedon())
                .photoUrl(club.getPhotoUrl())
                .updatedon(club.getUpdatedon())
                .build();
        return clubdto1;
    }

}
