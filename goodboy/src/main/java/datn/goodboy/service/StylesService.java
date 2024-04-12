package datn.goodboy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import datn.goodboy.model.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import datn.goodboy.model.entity.Styles;
import datn.goodboy.repository.StylesRepository;

@Service
public class StylesService {
    @Autowired
    private StylesRepository stylesRepository;

    public ArrayList<Styles> getAllStyles() {
        return (ArrayList<Styles>) stylesRepository.findAll();
    }

    public Page<Styles> findAll(Pageable pageable) {
        return stylesRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    public Styles add(Styles origin) {
        return stylesRepository.save(origin);
    }

    public Styles update(Integer id, Styles color) {
        Styles color1 = stylesRepository.findById(id).get();
        color1.setName(color.getName());
        color1.setUpdatedAt(color.getUpdatedAt());
        color1.setStatus(color.getStatus());
        return stylesRepository.save(color1);
    }

    public Styles getById(Integer id) {
        return stylesRepository.findById(id).get();
    }

    public Page<Styles> searchStylesByKeyword(String keyword, Pageable pageable) {
        return stylesRepository.searchByKeyword(keyword, pageable);
    }
    public List<Map<Integer, String>> getCombobox() {
        return stylesRepository.getComboBoxMap();
    }

    public void deleteStyles(Integer id) {
        Optional<Styles> styles = stylesRepository.findById(id);
        if (styles.isPresent()) {
            styles.get().setDeleted(!styles.get().isDeleted());
            stylesRepository.save(styles.get());
        }
    }

    public List<Styles> getStylesList() {
      return stylesRepository.getStylesList();
    }
}
