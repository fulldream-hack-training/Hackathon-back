package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.configs.StorageServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageServiceProperties properties;
    private final static ArrayList<String> staticSubDirs = new ArrayList<>();

    public void register(String string) {
        staticSubDirs.add(string);
        init();
    }

    private void init() {
        if (getRoot().exists()) {
            initSubdirs();
        } else {
            getRoot().mkdirs();
            initSubdirs();
        }
    }

    private File getRoot() {
        return new File(properties.path());
    }

    private void initSubdirs() {
        staticSubDirs.forEach(folder -> {
            File subFolder = new File(properties.path(), folder);

            if(!subFolder.exists()) {
                subFolder.mkdirs();
            }
        });
    }

}
