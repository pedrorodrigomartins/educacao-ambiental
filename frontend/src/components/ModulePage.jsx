import { Link } from "react-router-dom";
import VideoSection from "./VideoSection";
import ReflectionBlock from "./ReflectionBlock";
import NavigationButtons from "./NavigationButtons";

function ModulePage({ step, previousStep, nextStep }) {
  return (
    <main className="module-page">
      <div className="container module-shell">
        <Link className="back-link" to="/">
          ← Voltar para a jornada
        </Link>

        <div className="module-layout">
          <aside className="module-track" aria-label={`Etapa ${step.number} de 10`}>
            <span>{step.number}</span>
          </aside>

          <div className="module-panel">
            <header className="module-header">
              <p className="module-eyebrow">{step.eyebrow}</p>
              <h1>{step.title}</h1>
              <p className="module-subtitle">{step.subtitle}</p>
            </header>

            <article className="module-content">
              <VideoSection title={step.videoTitle} videoUrl={step.videoUrl} />

              <div className="content-body">
                {step.content.map((paragraph) => (
                  <p key={paragraph}>{paragraph}</p>
                ))}
              </div>

              {step.reflection && (
                <ReflectionBlock question={step.reflection} />
              )}

              {step.externalResource && (
                <aside className="external-resource">
                  <h2>{step.externalResource.title}</h2>
                  <p>{step.externalResource.description}</p>
                  <a
                    href={step.externalResource.url}
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    {step.externalResource.label}
                    <span aria-hidden="true"> ↗</span>
                    <span className="visually-hidden"> (abre em nova aba)</span>
                  </a>
                </aside>
              )}
            </article>

            <NavigationButtons
              previousStep={previousStep}
              nextStep={nextStep}
              optionalStep={step.optional}
            />
          </div>
        </div>
      </div>
    </main>
  );
}

export default ModulePage;
