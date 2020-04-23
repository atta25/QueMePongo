import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Tela {
    ALGODON{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Collections.singletonList(Tipo.CAMISA);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    },

    CUERO{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Arrays.asList(Tipo.CAMPERA, Tipo.ZAPATO, Tipo.PANTALON);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    },

    SEDA{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Arrays.asList(Tipo.CAMISA, Tipo.REMERA);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    },

    PIQUE{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Collections.singletonList(Tipo.CHOMBA);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    },

    LONA{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Collections.singletonList(Tipo.ZAPATILLAS);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    },

    ACETATO{
        @Override
        public boolean esConsistentePara(Tipo tipo) {
            List<Tipo> tiposDePrendaCompatibles = Collections.singletonList(Tipo.PANTALON);
            return this.contieneTipo(tiposDePrendaCompatibles, tipo);
        }
    };

    public abstract boolean esConsistentePara(Tipo tipo);

    protected Boolean contieneTipo(List<Tipo> tipos, Tipo tipo) {
        return tipos.contains(tipo);
    }
}
