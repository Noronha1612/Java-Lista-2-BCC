package questao03;

import java.time.LocalDateTime;

public interface Transacao {
    LocalDateTime getData();
    String getTipo();
    String getDescricao();
    String calcularTotal();
}
