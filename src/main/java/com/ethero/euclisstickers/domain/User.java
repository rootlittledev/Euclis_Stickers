package com.ethero.euclisstickers.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
@Data
public class User {

    @Id
    String id;
    String login;
    String display_name;
    String type;
    String broadcaster_type;
    String description;
    String profile_image_url;
    String offline_image_url;
    String view_count;
    String email;

}
