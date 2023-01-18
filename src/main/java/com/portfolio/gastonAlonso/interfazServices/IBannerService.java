package com.portfolio.gastonAlonso.interfazServices;

import com.portfolio.gastonAlonso.model.Banner;

import java.util.List;

public interface IBannerService {
    public List<Banner> verBanner();

    public void crearBanner(Banner banner);

    public void borrarBanner(Long id);

    public Banner buscarBanner(Long id);

    public Banner editarBanner(Banner banner);
}
