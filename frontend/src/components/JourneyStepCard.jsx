import { Link } from "react-router-dom";

function JourneyStepCard({ step, index, className = "", style }) {
  const classes = [
    "journey-card",
    `step-${index + 1}`,
    step.optional ? "optional-step" : "",
    step.id === 10 ? "summit-step" : ""
  ].filter(Boolean);

  if (className) {
    classes.push(className);
  }

  return (
    <Link
      className={classes.join(" ")}
      style={style}
      to={`/trilha/${step.slug}`}
      aria-label={`Etapa ${step.number}: ${step.title}${step.optional ? ", parada opcional" : ""}`}
    >
      <span className="journey-number">{step.number}</span>
      <div className="journey-copy">
        <h3>{step.shortTitle ?? step.title}</h3>
        <p>{step.subtitle}</p>
      </div>
      {step.optional && <span className="optional-badge">Opcional</span>}
      {step.id === 10 && <span className="summit-badge">Cume</span>}
    </Link>
  );
}

export default JourneyStepCard;
