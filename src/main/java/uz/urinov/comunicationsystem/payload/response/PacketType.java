package uz.urinov.comunicationsystem.payload.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class PacketType {
    private Integer id;
    @Enumerated(EnumType.STRING)
    private uz.urinov.comunicationsystem.entity.enums.PacketType name;
}
