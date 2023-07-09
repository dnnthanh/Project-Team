package repositorys;

import domainmodels.Size;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Ngọc Thanh
 */
public interface GuiSize {

    List<Size> getAll();

    int ThemSize(Size size);

    int XoaSize(UUID id);

    int CapNhatSize(Size size);

    Size GetSize(String maSize);

    String GetMaSize(UUID idSize);

    String GetTenSize(UUID idSize);
}
