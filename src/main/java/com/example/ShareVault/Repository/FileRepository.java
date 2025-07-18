package com.example.ShareVault.Repository;

import com.example.ShareVault.Entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
