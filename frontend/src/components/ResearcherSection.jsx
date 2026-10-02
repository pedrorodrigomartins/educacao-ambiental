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
            e meio ambiente. Sou apaixonada pela <strong>Educação Ambiental</strong> e acredito
            que ela deve fazer parte do trabalho de todos os professores,
            atravessando os diferentes componentes curriculares
            e dialogando com a realidade dos estudantes.
          </p>

          <p>
            Também me inquieta perceber que, muitas vezes, esse tema
            ainda não integra o cotidiano da sala de aula de forma transversal e contínua.
            Essa inquietação me impulsiona a estudar e buscar caminhos
            para aproximar a <strong>Educação Ambiental crítica</strong> da prática docente.
          </p>

          <p>
            Em 2010, recebi um <strong>prêmio de Cidadania da Associação Brasileira
            de Franquias</strong> pela produção, com meus alunos, do livro{' '}
            <cite>A Journey Through the Biomes</cite>, posteriormente traduzido como{' '}
            <cite>A caverna dos 7 enigmas — uma viagem pelos biomas brasileiros</cite>.
            Também participei de um congresso internacional em Ahmedabad, na Índia,
            relacionado à Carta da Terra, com o tema{' '}
            <cite>“Referencial ético para um mundo sustentável”</cite>.
          </p>

          <p>
            Hoje, minha pesquisa investiga as contribuições do{' '}
            <strong>Design for Change</strong> e da <strong>gamificação</strong> para
            o protagonismo dos estudantes e a cidadania ambiental.
            O <strong>Trilhas da Educação Ambiental</strong> nasce desse percurso e
            do desejo de apoiar outros professores na construção de projetos
            socioambientais com investigação, participação e intencionalidade pedagógica.
          </p>
        </div>
      </div>
    </section>
  );
}

export default ResearcherSection;
