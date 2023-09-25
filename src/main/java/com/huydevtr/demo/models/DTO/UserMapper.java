package com.huydevtr.demo.models.DTO;

import com.huydevtr.demo.models.DTOentities.RatingSlimDTO;
import com.huydevtr.demo.models.DTOentities.UserSlimDTO;
import com.huydevtr.demo.models.entities.Rating;
import com.huydevtr.demo.models.entities.User;
import com.huydevtr.demo.repositories.RatingRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface UserMapper {
    RatingSlimDTO ratingToRatingDTO(Rating rating);
    public User getUserByUserId(int userId);
    UserSlimDTO userToUserDTO(User user);
}
