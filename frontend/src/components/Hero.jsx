import { Link } from "react-router-dom";
import JourneyStepCard from "./JourneyStepCard";
import { journeySteps } from "../data/journey";
import mountainTrail from "../assets/images/Mountain Trail Summit Photo.jpg";

function Hero() {
  return (
    <section className="hero" id="inicio" aria-labelledby="home-title">
      <img
        className="hero-image"
        src={mountainTrail}
        alt="Trilha sinuosa atravessando uma encosta em direção aos cumes de uma montanha"
      />
      <div className="hero-overlay" aria-hidden="true" />
      <div className="container hero-shell">
        <div className="hero-copy">
          <p className="eyebrow">UMA JORNADA DE FORMAÇÃO DOCENTE</p>
          <h1 id="home-title">
            Trilhas da Educação Ambiental
          </h1>
          <p className="hero-description">
            Um percurso para a construção de projetos transformadores
          </p>

          <div className="hero-buttons">
            <Link to={`/trilha/${journeySteps[0].slug}`}>
              Comece sua jornada <span aria-hidden="true">↓</span>
            </Link>
          </div>
        </div>

        <nav
          className="hero-journey"
          id="trilha"
          aria-label="Etapas da jornada pela trilha"
        >
          <svg
            className="trail-line"
            viewBox="0 0 1000 1000"
            preserveAspectRatio="none"
            aria-hidden="true"
          >
            <path d="M40 820 C135 800 180 790 220 780 S345 740 400 720 S535 680 580 660 S720 600 900 520 C805 470 745 440 690 440 S565 465 500 480 S570 390 680 330 S790 365 860 390" />
          </svg>
          {journeySteps.map((step, index) => (
            <JourneyStepCard
              key={step.id}
              step={step}
              index={index}
              className="hero-card"
              style={{ "--trail-x": step.position.x, "--trail-y": step.position.y }}
            />
          ))}
        </nav>
      </div>
    </section>
  );
}

export default Hero;