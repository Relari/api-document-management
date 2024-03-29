package com.pe.relari.business.sqlite.documents.service.impl;

import com.pe.relari.business.sqlite.documents.dao.DocumentDao;
import com.pe.relari.business.sqlite.documents.model.domain.Document;
import com.pe.relari.business.sqlite.documents.service.DocumentService;
import com.pe.relari.business.sqlite.documents.util.DocumentUtil;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
class DocumentServiceImpl implements DocumentService {

  private final DocumentDao documentDao;

  @Override
  public List<Document> findAll() {
    return documentDao.findAll();
  }

  @Override
  public String create(Document document) {
    Integer id = documentDao.create(document);
    return DocumentUtil.buildDocumentId(id);
  }

  @Override
  public Document findById(Integer id) {
    return documentDao.findById(id);
  }

  @Override
  public void deleteById(Integer id) {
    Document document = documentDao.findById(id);

    log.debug("Validando que el documento exista.");
    if (Objects.nonNull(document)) {
      documentDao.deleteById(document.getId());
    }

  }

}
