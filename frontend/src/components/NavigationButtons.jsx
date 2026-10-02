import { Link } from "react-router-dom";

function NavigationButtons({ previousStep, nextStep, optionalStep }) {
  return (
    <nav className="module-navigation" aria-label="Navegação entre etapas">
      {previousStep ? (
        <Link className="nav-button secondary" to={`/trilha/${previousStep.slug}`}>
          ← Etapa anterior
        </Link>
      ) : (
        <span className="nav-button secondary disabled">← Etapa anterior</span>
      )}

      <Link className="nav-button ghost" to="/">
        Ver jornada
      </Link>

      {nextStep ? (
        <Link className="nav-button primary" to={`/trilha/${nextStep.slug}`}>
          {optionalStep ? "Seguir para a próxima etapa →" : "Próxima etapa →"}
        </Link>
      ) : (
        <span className="nav-button primary disabled">Próxima etapa →</span>
      )}
    </nav>
  );
}

export default NavigationButtons;
