package ru.vizgalin.smartHomeApplication.device.room.toilet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ToiletLight {

    @Id
    private long id;

    private boolean isWork;
}
