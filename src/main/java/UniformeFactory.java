public class UniformeFactory {
    public static Uniforme getUniforme(InstitucionName institucionName) {
        Institucion institucion;

        switch (institucionName) {
            case SAN_JUAN:
                institucion = new SanJuan();
                break;
            case JOHNSON:
                institucion = new Johnson();
                break;
            default: throw new InsTitutionNameInvalidException();
        }

        return new Uniforme(institucion.getPrendas());
    }
}
