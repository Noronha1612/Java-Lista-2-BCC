package questao03;

import java.time.LocalDateTime;

public interface Transacao {
    LocalDateTime geData();
    String getTipo();
    String getDescricao();
    String calcularTotal();
}
