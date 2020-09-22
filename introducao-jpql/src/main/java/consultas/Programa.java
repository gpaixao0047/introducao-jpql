package consultas;

public class Programa {
	public static void main(String[] args) {
		ConsultasJPQL consultas = new ConsultasJPQL();

		// System.out.println(consultas.listarTodasSeries());
		// System.out.println(consultas.listarSeriesCriadasNoAno2008());
		// System.out.println(consultas.listarSeriesCriadasNoAno2008(2013));
		// System.out.println(consultas.listarSeriesCujoNomeContenha("ng"));
		// System.out.println(consultas.recuperarSeriePorAnoENome("Gotham", 2013));
		//System.out.println(consultas.listarEpisodioDaSerie("Gotham"));
		System.out.println(consultas.recuperarSeriesComNumeroMinimoDeTemporada(3));
	}
}
