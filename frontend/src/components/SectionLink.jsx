import { useLayoutEffect } from "react";
import { Link, useLocation } from "react-router-dom";

function SectionLink({ id, children, onClick, ...props }) {
  const { pathname, hash } = useLocation();

  useLayoutEffect(() => {
    if (pathname !== "/" || hash !== `#${id}`) {
      return;
    }

    document.getElementById(id)?.scrollIntoView();
  }, [hash, id, pathname]);

  function handleClick(event) {
    onClick?.(event);

    if (!event.defaultPrevented && pathname === "/" && hash === `#${id}`) {
      document.getElementById(id)?.scrollIntoView();
    }
  }

  return (
    <Link to={`/#${id}`} onClick={handleClick} {...props}>
      {children}
    </Link>
  );
}

export default SectionLink;
