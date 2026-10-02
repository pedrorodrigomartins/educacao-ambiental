import SectionLink from "./SectionLink";
import { sectionNavigation } from "../data/sectionNavigation";

function Navbar() {
  return (
    <header className="site-header">
      <nav className="navbar container" aria-label="Navegação principal">
        <SectionLink className="logo" id="inicio">
          eCoLab
        </SectionLink>

        <div className="nav-links">
          {sectionNavigation.map(({ id, label }) => (
            <SectionLink key={id} id={id}>
              {label}
            </SectionLink>
          ))}
        </div>
      </nav>
    </header>
  );
}

export default Navbar;