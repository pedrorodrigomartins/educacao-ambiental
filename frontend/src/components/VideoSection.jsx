function getYouTubeId(videoUrl) {
  const url = new URL(videoUrl);

  if (url.hostname === "youtu.be") {
    return url.pathname.slice(1);
  }

  if (
    url.hostname === "youtube.com" ||
    url.hostname === "www.youtube.com"
  ) {
    return url.searchParams.get("v");
  }

  return null;
}

function VideoSection({ title, videoUrl }) {
  const videoId = getYouTubeId(videoUrl);

  if (!videoId) {
    throw new Error(`URL de vídeo do YouTube inválida: ${videoUrl}`);
  }

  return (
    <section className="video-section" aria-label="Vídeo da etapa">
      <div className="video-frame">
        <iframe
          src={`https://www.youtube-nocookie.com/embed/${encodeURIComponent(videoId)}`}
          title={title}
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          referrerPolicy="strict-origin-when-cross-origin"
          allowFullScreen
          loading="lazy"
        />
      </div>
    </section>
  );
}

export default VideoSection;
