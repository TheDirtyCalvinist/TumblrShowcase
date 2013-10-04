package com.ajh.TumblrShowcase;

/**
 * Created with IntelliJ IDEA.
 * User: thedirtycalvinist
 * Date: 10/3/13
 * Time: 7:37 PM
 * Copyright 2013 Aaron Haser
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class TumblrBlog {
    private String title;
    private String URL;

    public TumblrBlog(String title, String url)
    {
        this.title = title;
        this.URL = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    // hardcoded for convenience
    public static final TumblrBlog[] tumblrs = {new TumblrBlog("Why Today is the Worst Day of Charles' Life", "http://theworstdayofcharleslife.tumblr.com/"),
            new TumblrBlog("Mindgrub Memes", "http://mindgrub-memes.tumblr.com/"),
            new TumblrBlog("Subjective-C Api", "http://subjective-c-api.tumblr.com/"),
            new TumblrBlog("You will not go to space today", "http://youwillnotgotospacetoday.tumblr.com/")
    };
}
