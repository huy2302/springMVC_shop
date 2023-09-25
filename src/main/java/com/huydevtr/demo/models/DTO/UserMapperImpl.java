package com.huydevtr.demo.models.DTO;

import com.huydevtr.demo.models.DTOentities.RatingSlimDTO;
import com.huydevtr.demo.models.DTOentities.UserSlimDTO;
import com.huydevtr.demo.models.entities.Rating;
import com.huydevtr.demo.models.entities.User;
import com.huydevtr.demo.repositories.RatingRepository;
import com.huydevtr.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.processing.Generated;
import java.util.List;
@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2021-03-11T19:21:44+0100",
        comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Service
public class UserMapperImpl implements UserMapper{
    UserRepository userRepository;
    RatingRepository ratingRepository;

    public UserMapperImpl() {
    }
    @Autowired
    public UserMapperImpl(
            UserRepository userRepository,
            RatingRepository ratingRepository
    ) {
        this.userRepository = userRepository;
        this.ratingRepository = ratingRepository;
    }
    @Override
    public User getUserByUserId(int userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public UserSlimDTO userToUserDTO(User user) {
        return new UserSlimDTO(
                user.getUserId(),
                user.getUserName(),
                user.getBirthDay(),
                user.getEmail(),
                user.getPhoneNo()
        );
    }

    @Override
    public RatingSlimDTO ratingToRatingDTO(Rating rating) {
        RatingSlimDTO ratingSlimDTO = new RatingSlimDTO();
        ratingSlimDTO.setRatingId(rating.getRatingId());
        ratingSlimDTO.setProductId(rating.getProduct().getProductId());

        User user = getUserByUserId(rating.getUser().getUserId());
        ratingSlimDTO.setUserSlimDTO(userToUserDTO(user));
        ratingSlimDTO.setRating(rating.getRating());
        ratingSlimDTO.setDescription(rating.getDescription());

        return ratingSlimDTO;
    }


}
