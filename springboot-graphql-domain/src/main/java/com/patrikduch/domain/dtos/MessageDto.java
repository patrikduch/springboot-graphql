package com.patrikduch.domain.dtos;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class MessageDto implements Serializable {
    private UUID id;
    private String text;
}
