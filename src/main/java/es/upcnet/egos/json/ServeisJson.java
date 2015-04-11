package es.upcnet.egos.json;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import es.upcnet.egos.domain.Servei;

@Getter
@Setter
public class ServeisJson implements Serializable {
	private static final long serialVersionUID = -4633085886164438879L;

	private List<Servei> serveis;
}
