import SectionTitle from "./SectionTitle";
import researcherPortrait from "../assets/images/image.png";

function ResearcherSection() {
  return (
    <section className="researcher-section" id="sobre">
      <div className="container researcher-layout">
        <img
          className="researcher-photo"
          src={researcherPortrait}
          alt="Elisandra Person"
          loading="lazy"
          decoding="async"
        />
        <div className="researcher-copy">
          <SectionTitle
            eyebrow="Sobre a pesquisadora"
            title="Elisandra Person"
          />
          <p>
            Sou Elisandra Person, professora de Língua Inglesa e mestranda
            em Projetos Educacionais de Ciências na USP. Ao longo da minha
            jornada educacional, sempre me interessei pela relação entre educação
            e meio ambiente. Sou apaixonada pela Educação Ambiental e acredito
            que ela deve fazer parte do trabalho de todos os professores,
            atravessando os diferentes componentes curriculares
            e dialogando com a realidade dos estudantes.
          </p>
          <br />
          <p>
            Também me inquieta perceber que, muitas vezes, esse tema 
            ainda não integra o cotidiano da sala de aula de forma transversal e contínua.
            Essa inquietação me impulsiona a estudar e buscar caminhos
            para aproximar a Educação Ambiental crítica da prática docente.
          </p>
          <br />
          <p>
            Em 2010, recebi um prêmio de Cidadania da
            Associação Brasileira de Franquias pela produção,
            com meus alunos, do livro A Journey Through the Biomes,
            posteriormente traduzido como A caverna dos 7 enigmas
            — uma viagem pelos biomas brasileiros. Também participei
            de um congresso internacional em Ahmedabad, na Índia,
            relacionado à Carta da Terra,
            com o tema “Referencial ético para um mundo sustentável”.
          </p>
          <br />
          <p>
            Hoje, minha pesquisa investiga as contribuições do Design for Change
            e da gamificação para o protagonismo dos estudantes e a cidadania ambiental.
            O Trilhas da Educação Ambiental nasce desse percurso e
            do desejo de apoiar outros professores na construção de projetos
            socioambientais com investigação, participação e intencionalidade pedagógica.
          </p>
        </div>
      </div>
    </section>
  );
}

export default ResearcherSection;
