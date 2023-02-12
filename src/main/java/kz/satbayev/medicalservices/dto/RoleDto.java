package kz.satbayev.medicalservices.dto;

import kz.satbayev.medicalservices.entity.Role;
import kz.satbayev.medicalservices.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Long id;
    private final String name;
    private final Set<UserDto> users;

    /**
     * A DTO for the {@link User} entity
     */
    @Data
    public static class UserDto implements Serializable {
        private final Long id;
        private final String firstName;
        private final String middleName;
        private final String lastName;
        private final String fullName;
        private final Date createdDate;
    }
}