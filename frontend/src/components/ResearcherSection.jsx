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
            Professora de Língua Inglesa e pesquisadora em Educação Ambiental.
            Sua proposta aborda Educação Ambiental crítica, Design for Change,
            gamificação e formação docente.
          </p>
        </div>
      </div>
    </section>
  );
}

export default ResearcherSection;
