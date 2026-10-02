import { Navigate, useParams } from "react-router-dom";
import ModulePage from "../components/ModulePage";
import { journeySteps } from "../data/journey";

function JourneyModule() {
  const { slug } = useParams();
  const stepIndex = journeySteps.findIndex((step) => step.slug === slug);

  if (stepIndex === -1) {
    return <Navigate to="/" replace />;
  }

  const step = journeySteps[stepIndex];
  const previousStep = stepIndex > 0 ? journeySteps[stepIndex - 1] : null;
  const nextStep =
    stepIndex < journeySteps.length - 1 ? journeySteps[stepIndex + 1] : null;

  return <ModulePage step={step} previousStep={previousStep} nextStep={nextStep} />;
}

export default JourneyModule;
