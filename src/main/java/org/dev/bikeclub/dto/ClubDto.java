package org.dev.bikeclub.dto;

import lombok.Builder;
import lombok.Data;
import org.dev.bikeclub.model.User;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {
    private Long id;

    @NotEmpty(message = "Название клуба не должно быть пустым")
    private String title;
    @NotEmpty(message = "Фото не должно быть пустым")
    private String photoUrl;
    @NotEmpty(message = "Описание не должно быть пустым")
    private String content;
    private User user;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events;
}
