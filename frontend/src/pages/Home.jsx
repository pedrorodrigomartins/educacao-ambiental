import Hero from "../components/Hero";
import CategoryCard from "../components/CategoryCard";
import categorias from "../data/categorias";

function Home() {
  return (
    <main>
      <Hero />

      <section className="section">
        <h2>Sobre a plataforma</h2>
        <p>
          Este espaço foi desenvolvido para apoiar professores no acesso a
          materiais e recursos sobre Educação Ambiental, facilitando sua
          aplicação em aulas e projetos escolares.
        </p>
      </section>

      <section className="section">
        <h2>Categorias</h2>
        <div className="grid">
          {categorias.map((categoria) => (
            <CategoryCard
              key={categoria.id}
              titulo={categoria.titulo}
              descricao={categoria.descricao}
              rota={categoria.rota}
            />
          ))}
        </div>
      </section>
    </main>
  );
}

export default Home;