package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.blog.BlogCache;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.blog.BlogCollector;

import java.util.LinkedHashSet;
import java.util.Set;

public class BlogPostLoader
extends ItemSetLoader<BlogCache> {
    public BlogPostLoader() {
        new Thread(new BlogCollector()).start();
    }

    @Override
    public Set<BlogCache> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new LinkedHashSet<>();
    }
}
 