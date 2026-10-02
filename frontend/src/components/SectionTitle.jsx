function SectionTitle({ eyebrow, title, description, align = "left" }) {
  return (
    <div className={`section-heading ${align === "center" ? "center" : ""}`}>
      {eyebrow && <p className="section-eyebrow">{eyebrow}</p>}
      {title && <h2>{title}</h2>}
      {description && <p>{description}</p>}
    </div>
  );
}

export default SectionTitle;
