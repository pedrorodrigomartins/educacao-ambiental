import SectionTitle from "./SectionTitle";

function ContactSection() {
  return (
    <section className="contact-section" id="contato">
      <div className="container contact-layout">
        <div className="contact-copy">
          <SectionTitle
            title="Vamos conversar?"
            description="Tem dúvidas sobre a trilha ou quer compartilhar uma experiência de Educação Ambiental?"
          />
          <a className="contact-email" href="mailto:elisandraperson2@gmail.com">
            elisandraperson2@gmail.com
          </a>
        </div>
      </div>
    </section>
  );
}

export default ContactSection;
