package inaf.boris.Mapper;

import inaf.boris.Dto.ReponseUserDto;
import inaf.boris.Entity.User;

public class UserMapper {
    public static ReponseUserDto toDTO(User user){
        ReponseUserDto dto = new ReponseUserDto();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
