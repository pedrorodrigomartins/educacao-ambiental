import SectionLink from "./SectionLink";
import { sectionNavigation } from "../data/sectionNavigation";

function Footer() {
  return (
    <footer className="footer">
      <div className="container">
        <div className="footer-content">
          <section className="footer-about" aria-labelledby="footer-brand">
            <h2 id="footer-brand">eCoLab</h2>
            <p className="footer-project-name">Trilhas da Educação Ambiental</p>
            <p>
              Uma jornada de formação docente voltada à Educação Ambiental,
              Design for Change e projetos socioambientais.
            </p>
          </section>

          <nav className="footer-navigation" aria-label="Navegação do rodapé">
            <h2>Navegação</h2>
            <ul>
              {sectionNavigation.map(({ id, label }) => (
                <li key={id}>
                  <SectionLink id={id}>{label}</SectionLink>
                </li>
              ))}
            </ul>
          </nav>

          <section
            className="footer-contact"
            aria-labelledby="footer-contact-title"
          >
            <h2 id="footer-contact-title">Contato</h2>
            <p>Elisandra Person</p>
            <a href="mailto:elisandraperson2@gmail.com">
              elisandraperson2@gmail.com
            </a>
          </section>
        </div>

        <div className="footer-bottom">
          <p>
            © {new Date().getFullYear()} eCoLab · Trilhas da Educação Ambiental
          </p>
        </div>
      </div>
    </footer>
  );
}

export default Footer;