package com.user.mappingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.mappingservice.model.Response;
import com.user.mappingservice.model.User;
import com.user.mappingservice.model.Users;
import com.user.mappingservice.model.UserDetails;
import com.user.mappingservice.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MapService {

    @Autowired
    private ObjectMapper objectMapper;

    public Response getUser(User user) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(Constants.USER_DETAILS);
        UserDetails details = objectMapper.readValue(is, UserDetails.class);
        Response response = new Response();
        for (Users usersDetails : details.getUsers()) {
            response.setCustId(usersDetails.getId());
            response.setCompanyName(usersDetails.getCompany());
            response.setBranch(usersDetails.getDept());
        }

        return response;
    }

}
