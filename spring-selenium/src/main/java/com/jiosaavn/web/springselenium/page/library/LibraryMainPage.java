package com.jiosaavn.web.springselenium.page.library;

import com.jiosaavn.web.springselenium.kelvin.annotations.Page;
import com.jiosaavn.web.springselenium.page.BaseConfig;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class LibraryMainPage extends BaseConfig {





    @Autowired
    private Albums albums;

    @Autowired
        private ListeningHistory listeningHistory;

        @Autowired
        private Songs songs;


    public void launchAllLibraryPages() throws InterruptedException {

        this.albums.openAlbumPageInNewTab();
        this.songs.openSongsPageInNewTab();
        this.listeningHistory.openHistoryPageInNewTab();

    }

    public Albums getAlbums() {
        return  albums;
    }

    public ListeningHistory getListeningHistory() {
            return listeningHistory;
    }

    public Songs getSongs() {
        return songs;
    }

    @Override
    public boolean isAt() {
        return false;
    }
}
