function ReflectionBlock({ question }) {
  return (
    <aside className="reflection-block" aria-label="Atividade de reflexão">
      <p className="reflection-label">Para começar</p>
      <h3>{question}</h3>
    </aside>
  );
}

export default ReflectionBlock;
